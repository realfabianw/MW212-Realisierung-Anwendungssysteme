import UserService from "./UserService";
import axios from "axios";

class StockService {
    jwtToken = "";
    allStocks = [];
    singleStock = [];

    async getAllStocks() {
        console.log("Loading all available Stocks from DB with Authorization Token: " + this.jwtToken.Authorization);
        return await axios
            .get("http://localhost:9090/stocks",
                {headers: UserService.getAuthorizationHeader()}
            )
            .then((response) => {
                console.log(response);
                this.allStocks = response.data;
                return true;
            })
            .catch((error) => {
                console.log(error);
                return false;
            });
    }

    async getStockById(stockId) {
        console.log("Loading all available Stocks from DB with Authorization Token: " + this.jwtToken.Authorization);
        return await axios
            .get("http://localhost:9090/stocks/" + stockId,
                {headers: UserService.getAuthorizationHeader()}
            )
            .then((response) => {
                console.log(response);
                this.singleStock = response.data;
                return true;
            })
            .catch((error) => {
                console.log(error);
                return false;
            });
    }
}

export default new StockService();
