Steps For Running application 

Fisrt clone git repo (https://github.com/rockabhisingh/Unicodez) and move to master branch .

import this project in your eclipse as a maven .

clean and install project .

run all the sql commands src\main\resources/db.sql in your system .

change your mysql credentails(username and password) in application.properties.

open CustomersApplication.java and run as java application .

and type this url (http://localhost:8080/getDetails).

This output will come 


[{"custName":"Unicoz","transactionDate":"13 August 2021","monthlyTotal":2000,"monthlyReward":3850,"total":4000,"totalReward":7850},{"custName":"Unicoz","transactionDate":"13 July 2021","monthlyTotal":1000,"monthlyReward":1850,"total":4000,"totalReward":7850},{"custName":"Unicoz","transactionDate":"13 June 2021","monthlyTotal":1000,"monthlyReward":1850,"total":4000,"totalReward":7850},{"custName":"Unicoz1","transactionDate":"13 August 2021","monthlyTotal":500,"monthlyReward":850,"total":1500,"totalReward":2850},{"custName":"Unicoz1","transactionDate":"13 July 2021","monthlyTotal":500,"monthlyReward":850,"total":1500,"totalReward":2850},{"custName":"Unicoz1","transactionDate":"13 June 2021","monthlyTotal":500,"monthlyReward":850,"total":1500,"totalReward":2850},{"custName":"Unicoz2","transactionDate":"13 August 2021","monthlyTotal":200,"monthlyReward":250,"total":600,"totalReward":1050},{"custName":"Unicoz2","transactionDate":"13 July 2021","monthlyTotal":200,"monthlyReward":250,"total":600,"totalReward":1050},{"custName":"Unicoz2","transactionDate":"13 June 2021","monthlyTotal":200,"monthlyReward":250,"total":600,"totalReward":1050},{"custName":"Unicoz","transactionDate":"13 August 2021","monthlyTotal":2000,"monthlyReward":3850,"total":4000,"totalReward":7850}]

