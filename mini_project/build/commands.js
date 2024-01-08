"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Commands = void 0;
class Commands {
    constructor() {
        this.names = [
            'Palindrome - Check if the input is a palindrome',
            'Lower - Check if all characters in the input are lowercase',
            'Digits - Check if all characters in the input are digits',
            'Armstrong - Check if the input is an "Armstrong Number"',
            'Nationalize - check the nationality probability of given first name',
            'Exit - Exit successfully from the application'
        ];
    }
    printCommandsChoices() {
        let i = 0;
        this.names.forEach(element => {
            console.log(`${++i} - ${element}`);
        });
    }
}
exports.Commands = Commands;
