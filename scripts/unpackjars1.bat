@echo off
echo Unpacking file '%1.jar'
java\bin\unpack200 %1.pack %1.jar
del /f /q %1.pack
