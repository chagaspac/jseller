# JSeller

This java project is a tool for extract easilier data from bseller/kanlo ecommerce API.

## Dependencies
This JAR depends on Commons IO 2.4 (http://archive.apache.org/dist/commons/io/binaries/)
After import the JAR into your project, you can instantiate the main bseller reader as follow:
```
BSellerReader bsr = new BSellerReader("USERNAME", "PASSWORD", "BASE_ECOMMERCE_URL");
```

## Customers
Instantiate BSellerReader and call getCustomers

### Parameters for getCustomers
- int max: return the quantity of customers. If less or equals to 0 return **ALL** customers.
- Boolean optin: return only the customers who marked the checkbox that allows to send emails to his personal email. If null, get **ALL** customers, no matter the optin value (true/false).

### Code example

```
try {
	List<Customer> l = bsr.getCustomers(201, true);
	...
} catch (TopLevelException e) {
	...
}
```

## Orders
Instantiate BSellerReader and call getOrders

### Parameters for getOrders
- String start: Date in format "yyyy-MM-dd"
- String end: Date in format "yyyy-MM-dd"
- int version: version of your request **(highly recommended 14)**
- OrderStatus orderStatus: enum (available inside of this jar) that tells the status of orders that you want to get **ALL** customers

### Code example

```
try {
	List<Customer> l = bsr.getOrders("2016-04-01", "2016-04-30", 14, OrderStatus.PAYMENT_APPROVED);
	...
} catch (TopLevelException e) {
	...
}
```
