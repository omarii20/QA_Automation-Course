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
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const readlineSync = __importStar(require("readline-sync"));
const chalk_1 = __importDefault(require("chalk"));
const commands_1 = require("./commands");
const commandManager_1 = require("./commandManager");
class App {
    constructor() {
        this.commands = new commands_1.Commands();
        this.commandsFunc = new commandManager_1.CommandManager();
    }
    run() {
        return __awaiter(this, void 0, void 0, function* () {
            const commandsCount = this.commands.names.length;
            while (true) {
                yield this.delay(1000);
                console.log(chalk_1.default.bold.green("\nThe avaliable commands are:"));
                this.commands.printCommandsChoices();
                const commandIndex = readlineSync.question(chalk_1.default.bold.cyan('\nEnter the number of the command: '));
                const parsedIndex = parseInt(commandIndex, 10);
                if (parsedIndex === commandsCount) {
                    console.log(chalk_1.default.bold.green('\nExiting the program.'));
                    break;
                }
                else if (this.isValidCommand(parsedIndex, commandsCount)) {
                    this.executeCommand(parsedIndex);
                }
                else {
                    console.log(chalk_1.default.bold.red('Invalid command. Please enter a valid number.\n'));
                }
            }
        });
    }
    isValidCommand(commandIndex, commandsCount) {
        return !isNaN(commandIndex) && commandIndex > 0 && commandIndex <= commandsCount;
    }
    executeCommand(commandIndex) {
        switch (commandIndex) {
            case 1:
                this.commandsFunc.checkPalindrome();
                break;
            case 2:
                this.commandsFunc.checkLowercase();
                break;
            case 3:
                this.commandsFunc.checkDigits();
                break;
            case 4:
                this.commandsFunc.checkArmstrong();
                break;
            case 5:
                this.commandsFunc.checkNationality();
                break;
            default:
                console.log(chalk_1.default.bold.red('Invalid command. Please enter a valid number.'));
        }
    }
    delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}
const app = new App();
app.run();
