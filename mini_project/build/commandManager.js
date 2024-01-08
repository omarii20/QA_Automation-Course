"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.CommandManager = void 0;
const readlineSync = __importStar(require("readline-sync"));
const checkNationalityApi_1 = require("./checkNationalityApi");
class CommandManager {
    checkPalindrome() {
        const input = readlineSync.question('Enter a string: ');
        let start = 0;
        let end = input.length - 1;
        let isPalindrome = true;
        while (start < end) {
            if (input[start] !== input[end]) {
                isPalindrome = false;
            }
            start++;
            end--;
        }
        console.log(`Is Palindrome: ${isPalindrome}\n`);
    }
    checkLowercase() {
        const input = readlineSync.question('Enter a string: ');
        if (this.isLettersOnly(input)) {
            const isLowercase = input === input.toLowerCase();
            console.log(`Is Lowercase: ${isLowercase}\n`);
        }
        else {
            console.log('The input contains characters other than letters.\n');
        }
    }
    isLettersOnly(input) {
        const onlyLetters = /^[A-Za-z]+$/;
        return onlyLetters.test(input);
    }
    checkDigits() {
        const input = readlineSync.question('Enter a string: ');
        let counter = 0;
        let isDigits = true;
        while (counter < input.length) {
            if (isNaN(parseInt(input[counter]))) {
                isDigits = false;
            }
            counter++;
        }
        console.log(`Are all characters digits: ${isDigits}\n`);
    }
    checkArmstrong() {
        const input = readlineSync.question('Enter a number: ');
        const num = parseInt(input, 10);
        const isArmstrong = this.isArmstrongNumber(num);
        console.log(`Is Armstrong Number: ${isArmstrong}\n`);
    }
    isArmstrongNumber(num) {
        const numStr = num.toString();
        let sum = 0;
        for (let i = 0; i < numStr.length; i++) {
            const digitValue = parseInt(numStr[i], 10);
            sum += Math.pow(digitValue, numStr.length);
        }
        return num === sum;
    }
    checkNationality() {
        return __awaiter(this, void 0, void 0, function* () {
            const firstName = readlineSync.question('Enter a first name: ');
            const newApi = new checkNationalityApi_1.CheckNationalityApi();
            const result = yield newApi.checkNationality(firstName);
            if (result) {
                console.log(`${result === null || result === void 0 ? void 0 : result.country} ${result === null || result === void 0 ? void 0 : result.probability}`);
            }
            else {
                console.log(`No country data found for ${firstName} name.`);
            }
        });
    }
}
exports.CommandManager = CommandManager;
