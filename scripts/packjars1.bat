@echo off
echo Packing file '%1.jar'
"%JAVA_HOME%\bin\pack200" -J-Xmx256M -g %1.pack %1.jar
rem call pack200n %1
