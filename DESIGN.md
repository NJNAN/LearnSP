# 设计思路

本项目演示了一个采用 **Spring Boot** 构建的最小化 CRUD Web 应用，
通过 H2 内存数据库存储 `Item` 实体。以下内容将简要介绍整体结构与实现方式。

## 项目结构

- **pom.xml** – Maven 构建文件，包含 Spring Boot 与 H2 依赖。
- **DemoApplication.java** – 应用入口，使用 `@SpringBootApplication` 注解。
- **Item.java** – JPA 实体类，对应数据库记录。
- **ItemRepository.java** – Spring Data 仓库接口，提供基本 CRUD 操作。
- **ItemService.java** – 业务层，封装对仓库的访问。
- **ItemController.java** – MVC 控制器，处理 Web 请求。
- **templates/** – 放置 Thymeleaf 模板的目录，用于渲染页面。
- **static/css/** – 简单的样式表，提供基础页面样式。

## 工作流程

1. 应用从 `DemoApplication` 启动。`application.properties` 中配置 H2 数据库，启动时会在内存中创建。
2. 控制器统一处理 `/items` 路径下的请求，调用 `ItemService` 完成列表、创建、更新和删除等操作。服务层内部使用 `ItemRepository` 进行数据持久化。
3. `list.html` 用于展示所有条目并提供新增或编辑链接；`form.html` 既可创建，也可编辑条目。
4. 控制器方法返回视图名后，由 Spring Boot 调用相应的 Thymeleaf 模板进行页面渲染。
5. `static/css/styles.css` 中的样式表使界面保持简洁美观。

## 启动方式

确认本地已安装 Maven，执行：

```bash
mvn spring-boot:run
```

浏览器访问 `http://localhost:8080/items` 即可体验完整的 CRUD 功能。由于使用的是内存数据库，应用停止后数据会消失。
