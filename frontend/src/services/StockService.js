import UserService from "./UserService";
import axios from "axios";

export default class StockService {
  static instance = null;
  static getInstance() {
    if (StockService.instance == null) {
      StockService.instance = new StockService();
      console.log("Created a new instance of StockService");
    }
    return this.instance;
  }

  async addStock(name, symbol, isin, wkn) {
    let token = UserService.getInstance().getAuthorizationHeader();
    console.log(
      "Adding Stock to DB with Authorization Token: " + token.Authorization
    );

    let body = {
      name: name,
      symbol: symbol,
      isin: isin,
      wkn: wkn,
    };
    return await axios
      .post("http://localhost:9090/stocks", body, {
        headers: token,
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

  async getAllStocks() {
    let token = UserService.getInstance().getAuthorizationHeader();
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
    let token = UserService.getInstance().getAuthorizationHeader();
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

  async getTicks(stockId) {
    let token = UserService.getInstance().getAuthorizationHeader();
    console.log(
      "Loading ticks from stock id " +
        stockId +
        " from DB with Authorization Token: " +
        token.Authorization
    );
    return await axios
      .get("http://localhost:9090/ticks?stockId=" + stockId, {
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
