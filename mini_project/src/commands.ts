export class Commands {
    names: string[] = [
        'Palindrome - Check if the input is a palindrome',
        'Lower - Check if all characters in the input are lowercase',
        'Digits - Check if all characters in the input are digits',
        'Armstrong - Check if the input is an "Armstrong Number"',
        'Nationalize - check the nationality probability of given first name',
        'Exit - Exit successfully from the application'
    ];

    printCommandsChoices() {
        let i: number = 0;
        this.names.forEach(element => {
            console.log(`${++i} - ${element}`);
        });
    }
}
