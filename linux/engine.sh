#!/bin/bash

show_menu() {
	echo "=========================="
	echo "   Menu de Sélection"
	echo "=========================="
	echo "1. Pendule Double"
	echo "2. Balle rebondissante"
	echo "0. Quitter"
	echo "=========================="
	echo "Choisissez une option (0-2):"
}

while true
do
	clear
	show_menu

	read option

	case $option in
		1)
			java -jar exe/pendule.jar
			;;
		2)
			java -jar exe/rebond.jar
			;;
		0)
			echo "Au revoir!"
			break
			;;
		*)
			echo "Option invalide, veuillez choisir une option valide."
			;;
	esac

	echo "Appuyez sur n'importe quelle touche pour continuer..."
	read -n 1 -s
done
