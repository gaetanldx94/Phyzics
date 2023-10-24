@echo off

cd ..

REM Définir les chemins
set "src_dir=src"
set "bin_dir=bin"
set "exe_dir=exe"

REM Créer le dossier de destination s'il n'existe pas
if not exist "%bin_dir%" mkdir "%bin_dir%"
if not exist "%exe_dir%" mkdir "%exe_dir%"

REM Compiler les projets
for /d %%i in (%src_dir%\*) do (
	setlocal enabledelayedexpansion
	set "project_name=%%~nxi"
	set "project_bin_dir=!bin_dir!\!project_name!"
	echo Compilation de !project_name!...
	javac !src_dir!\!project_name!\*.java -d !project_bin_dir!

	REM Créer un fichier manifest spécifique au projet
	echo Main-Class: Main > "!bin_dir!\META-INF\MANIFEST.MF"

	REM Créer le fichier JAR
	jar -cvfm "!exe_dir!\!project_name!.jar" "!bin_dir!\META-INF\MANIFEST.MF" -C "!project_bin_dir!" .
	endlocal
)