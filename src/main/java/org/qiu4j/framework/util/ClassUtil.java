package org.qiu4j.framework.util;/*
 *@Author:WuRen
 *@Description:類操作工具類
 *@date: 21:49 2018/1/1
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final  class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /*
     * @Author:WuRen
     * @Description: 獲取類加載其
     * @Date: 21:52 2018/1/1
     * @param:  * @param null
    */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className,boolean isInitialized){
        Class<?> cls;
        try {
            cls = Class.forName(className,isInitialized,getClassLoader());

        }catch (ClassNotFoundException e){
            LOGGER.error("load class failure",e);
            throw  new RuntimeException(e);
        }
        return cls;
    }

    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls =
                    getClassLoader().getResources(packageName.replace(".","/"));

            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url != null){
                    String protocal = url.getProtocol();
                    if(protocal.equals("file")){
                        String packagePaht = url.getPath().replace("%20","");
                        addClass(classSet,packagePaht,packageName);
                    }else if(protocal.equals("jar")){
                        JarURLConnection jarURLConnection =
                                (JarURLConnection)url.openConnection();
                        if(jarURLConnection != null){
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if(jarFile != null){
                                Enumeration<JarEntry> jarEntities = jarFile.entries();
                                while (jarEntities.hasMoreElements()){
                                    JarEntry jarEntry = jarEntities.nextElement();
                                    String jarEntityName = jarEntry.getName();
                                    if(jarEntityName.endsWith(".class")){
                                        String className = jarEntityName.
                                                substring(0,jarEntityName.lastIndexOf(".")).
                                                replaceAll("/",".");
                                        doAddClass(classSet,className);
                                    }


                                }
                            }

                        }

                    }

                }
            }
        }catch (Exception e){
            LOGGER.error("get class set failure",e);
            throw new RuntimeException(e);
        }

        return classSet;
    }

    public static void addClass(Set<Class<?>> classSet,String packagePath,String packageName){
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class"))
                        ||(file.isDirectory());
            }
        });

        for(File file:files){

            String fileName = file.getName();
            if(file.isFile()){
                String className = fileName.substring(0,fileName.lastIndexOf("."));
                if(StringUtil.isNotEmpty(packageName)){
                    className = packageName + "." + className;
                    doAddClass(classSet,className);
                }
            }else{
                String subPackagePath = fileName;
                if(StringUtil.isNotEmpty(subPackagePath)){
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if(StringUtil.isNotEmpty(packageName)){
                    subPackageName = packageName + "" + subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }
        }



    }

    public static void doAddClass(Set<Class<?>> classSet,String className){
        Class<?> cls = loadClass(className,false);
        classSet.add(cls);
    }

}
