import axios from "axios";

export default class UserService {
  static instance = null;
  static getInstance() {
    if (UserService.instance == null) {
      UserService.instance = new UserService();
      console.log("Created a new instance of UserService");
    }
    return this.instance;
  }

  jwtToken = "";

  getAuthorizationHeader() {
    return { Authorization: "Bearer " + this.jwtToken };
  }

  async register(firstname, lastname, email, password) {
    return await axios
      .post("http://localhost:9090/register", {
        firstName: firstname,
        lastName: lastname,
        email: email,
        password: password,
      })
      .then((response) => {
        console.log(response);
        return true;
      })
      .catch((error) => {
        console.log(error);
        return false;
      });
  }

  async login(email, password) {
    console.log("Logging in with credentials: " + email + ", " + password);
    return await axios
      .post("http://localhost:9090/login", {
        email: email,
        password: password,
      })
      .then((response) => {
        console.log(response);
        this.jwtToken = response.data;
        return true;
      })
      .catch((error) => {
        console.log(error);
        return false;
      });
  }
}
