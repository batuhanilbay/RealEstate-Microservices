
# Real Estate Microservices 

RealEstate --> Proje temel işlemleri yürütülür.

RealEstate-Payment --> Payment Modelini Barındırır.

RealEstate-Eureka --> Service Discovery amacı ile oluşturulmuştur.

RealEstate-Gateway --> Yönlendirme işlemleri için oluşturulmuştur.

RealEstate-Auth --> Yetkilendirme ve token oluşturmak için kullanılmıştır.

RealEstate-Inventory--> RabbitMQ ile Queue işlemleri için oluşturulmuştur.


# Proje Hakkında 

Temel seviyede emlak ile ilgili kayıt olarak kullanılması için tasarlanmıştır. 
Kayıt oluşturmak için Email ve Password ile token alımı yapılır.
Gateway sayesinde istenilen CRUD operasyonlara bu token aracılığı ile yetki verilir.
İstenilen servise Gateway portu üzerinden ulaşılabilir.




## Kullanılan Teknolojiler

- Spring
- Spring Security
- JPA
- RabbitMQ
- FeignClient
- MySQL
- Service Discovery
- Gateway
- Unit Test
- PostMan


  
## API Kullanımı

### Bazı API Kullanımları

#### Tüm kullanıcıları listeleme

```http
  GET /users
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `application/json` | `UserDto` | **DTO ile kullanılır**. Model sınıfı üzerinden erişilmez. |


#### Kullanıcı oluşturma
```http
  POST /users
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `gerekli özellikler`      | `UserDto` | **Kullanıcı oluşturulur**.  |


#### Kullanıcı id 

```http
  GET /users/{userId}
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `UserDto` | **İstenilen userId ile kullanıcı getirilir**. |


#### Tüm ilanları listeleme

```http
  GET /adverts
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `application/json`      | `AdvertDto` | **DTO ile kullanılır**. Model sınıfı üzerinden erişilmez. |




  
## Ekren Görüntüleri


- UML 
 
 
 
 
  ![UMLDiagram](https://user-images.githubusercontent.com/44746773/159812458-fc5de913-b12e-4b05-af46-f31681b666c2.png)

- Test Coverage
  
  
  
  
  ![TestCovarege](https://user-images.githubusercontent.com/44746773/159812652-395eb685-b0f4-4334-abb2-4a561e69b3f1.PNG)


- User MySQL Örnek 
  
  
  
  ![MySqlUser](https://user-images.githubusercontent.com/44746773/159812922-3c5dad5d-833e-4154-b6bc-8b6cc2c0c3ee.PNG)


- Advert MySQL Örnek 
  
  
  
  ![GetAdvertMySQL](https://user-images.githubusercontent.com/44746773/159813701-60740a31-b703-4bad-a94f-7cdbc40831e6.PNG)
  
## Katkı

Bu proje katıldığım "Hepsiemlak Java Spring Bootcamp" sonunda hazırlanmıştır.

Bana bu fırsatı veren Patika.dev ve Hepsiemlak ekibine teşekkür ederim.

Ayrıca, Bootcamp süresi boyuunca yanımızda olan eğitmenimiz Cem DIRMAN'a teşekkür ederim.



  
