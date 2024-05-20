Omni        

Application that is supposed to gather and unite information from world organizations about missing and wanted people.

1. Spring boot multimodal project for easier maintenance, usability, etc. 
2. Version control from global properties in one place
3. Using JDBC - Dao pattern
4. Junit testing 
5. PostgresDB - dockerized 
6. Flyway migration

Modules 
1. Persistence 
    - this module is supposed to serve as gateway to database 
    - we define and implement here basic crude operations
    - using JDBC to access, manipulate and save data
    - handle cases - for example where there is not required parameter 
   


USED material and documentation
- https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/howto-data-access.html 
- https://documentation.red-gate.com/fd/flyway-cli-and-api-183306238.html
- https://www.digitalocean.com/community/tutorials/dao-design-patternjd
- https://spring.io/guides/gs/relational-data-access
- https://sabledhiraj.medium.com/spring-boot-multi-module-project-b984888a35d9
- https://bootify.io/multi-module/best-practices-for-spring-boot-multi-module.html