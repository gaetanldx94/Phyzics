@echo off
title Menu de Sélection
cls
:menu
echo ==========================
echo      Menu de Sélection
echo ==========================
echo 1. Pendule Double
echo 2. Balle rebondissante
echo 3. Fluide
echo 0. Quitter
echo ==========================
set /p option=Choisissez une option (0-3):
if "%option%"=="1" (
	java -jar exe/pendule.jar
) else if "%option%"=="2" (
	java -jar exe/rebond.jar
) else if "%option%"=="3" (
	java -jar exe/Fluide.jar
) else if "%option%"=="0" (
	echo Au revoir!
	exit /b
) else (
	echo Option invalide, veuillez choisir une option valide.
)
pause
cls
goto :menu