"use strict";
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
exports.CheckNationalityApi = void 0;
class CheckNationalityApi {
    checkNationality(firstName) {
        return __awaiter(this, void 0, void 0, function* () {
            try {
                const response = yield fetch(`https://api.nationalize.io/?name=${firstName}`);
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                const data = yield response.json();
                if (data.country && data.country.length > 0) {
                    const result = {
                        country: data.country[0].country_id,
                        probability: (data.country[0].probability * 100) + "%"
                    };
                    return result;
                }
                else {
                    return null;
                }
            }
            catch (error) {
                return null;
            }
        });
    }
}
exports.CheckNationalityApi = CheckNationalityApi;
