export class CheckNationalityApi {
    async checkNationality(firstName: string) {
        try {
            const response = await fetch(`https://api.nationalize.io/?name=${firstName}`);

            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const data = await response.json();

            if (data.country && data.country.length > 0) {
                const result = {
                    country: data.country[0].country_id,
                    probability: (data.country[0].probability * 100) + "%"
                };
                return result;
            } else {
                // console.error('No country data found for the given name.');
                return null;
            }
        } catch (error) {
            // console.error('Error:', error);
            return null;
        }
    }
}
