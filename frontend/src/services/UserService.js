import axios from "axios";

class UserService {
    async register(firstname, lastname, email, password) {
        await axios.post(
            "http://localhost:9090/register",
            {
                firstName: firstname,
                lastName: lastname,
                email: email,
                password: password
            },
        ).then(response => {
            console.log(response);
            return response.data;
        }).catch(error => {
            console.log(error);
        });
    }

    async login(email, password) {
        await axios.post(
            "http://localhost:9090/login",
            {
                email: email,
                password: password
            },
        ).then(response => {
            console.log(response);
            return response.data;
        }).catch(error => {
            console.log(error);
        });
    }
}

export default new UserService();
