/*
 * Main script to setup algosvers on installation
 */

//--utilizza le special variables provided by Gant
String source = "${pluginBasedir}"
String dest = "${basedir}"
source = dest + "/" + source + "/"
dest = dest + "/"

//--directory dell'applicazione
String appDir = "grails-app/"
String confDir = "${appDir}conf/"
String i18Dir = "${appDir}i18n/"

// copy readme into project
copyFile(source, dest, "${appDir}README", "README-Vers")
print('------------')
print('Algosvers - creato (o sovrascritto) README-Vers')
print('------------')

// copy VersioneBootStrap into project
moveFile(source, dest, "${confDir}VersioneBootStrap.groovy")
print('------------')
print('Algosvers - creato (NON sovrascritto) VersioneBootStrap')
print('------------')

// copy i18n into project
copyFile(source, dest, "${i18Dir}algosvers.properties")
print('------------')
print('Algosvers - creato (o sovrascritto) grails-app/i18n/algosvers.properties')
print('------------')

public static copyFile(String srcDirPath, String dstDirPath, String fileName) {
    copyFile(srcDirPath, dstDirPath, fileName, fileName)
} // fine del metodo

public static moveFile(String srcDirPath, String dstDirPath, String fileName) {
    moveFile(srcDirPath, dstDirPath, fileName, fileName)
} // fine del metodo

public static copyFile(String srcDirPath, String dstDirPath, String srcFileName, String dstFileName) {
    String srcFile = srcDirPath + srcFileName
    String destFile = dstDirPath + dstFileName

    copyFile(srcFile, destFile)
    deleteFile(srcFile)
} // fine del metodo

public static moveFile(String srcDirPath, String dstDirPath, String srcFileName, String dstFileName) {
    String srcFile = srcDirPath + srcFileName
    String destFile = dstDirPath + dstFileName

    copyFile(srcFile, destFile)
} // fine del metodo

public static copyFile(String srcFile, String destFile) {
    new AntBuilder().copy(file: srcFile, tofile: destFile, overwrite: true)
} // fine del metodo

public static deleteFile(String pathFile) {
    new AntBuilder().delete(file: pathFile)
} // fine del metodo
