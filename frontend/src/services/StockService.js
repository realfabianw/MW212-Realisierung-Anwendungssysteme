import UserService from "./UserService";
import axios from "axios";

class StockService {
  async getAllStocks() {
    let token = UserService.getAuthorizationHeader();
    console.log(
      "Loading all available Stocks from DB with Authorization Token: " +
        token.Authorization
    );
    return await axios
      .get("http://localhost:9090/stocks", {
        headers: token,
      })
      .then((response) => {
        console.log(response);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
        return [];
      });
  }

  async getStockById(stockId) {
    let token = UserService.getAuthorizationHeader();
    console.log(
      "Loading stock " +
        stockId +
        " from DB with Authorization Token: " +
        token.Authorization
    );
    return await axios
      .get("http://localhost:9090/stocks/" + stockId, {
        headers: token,
      })
      .then((response) => {
        console.log(response);
        return response.data;
      })
      .catch((error) => {
        console.log(error);
        return false;
      });
  }
}

export default new StockService();
