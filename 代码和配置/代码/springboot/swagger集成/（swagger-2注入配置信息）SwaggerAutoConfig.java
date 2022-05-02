package com.sxt.cloud.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //使用注解开启Swagger2
public class SwaggerAutoConfig {

	@Autowired
	private SwaggerProperty swaggerProperty;
	
	//swagger-2需要的配置
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(getApiInfo()).
					select().
						apis(RequestHandlerSelectors.basePackage(swaggerProperty.getBasePackage())).
							build();
		
	}

	/**介绍api， api的作者，名称，版本，维护
	 * @return
	 */
	private ApiInfo getApiInfo() {
		Contact contact = new Contact(swaggerProperty.getName(), swaggerProperty.getUrl(), swaggerProperty.getEmail());
		return new ApiInfoBuilder().contact(contact).
					title(swaggerProperty.getTitle()).
						version(swaggerProperty.getVersion()).
							termsOfServiceUrl(swaggerProperty.getTermsOfServiceUrl()).
								license(swaggerProperty.getLicense()).
									licenseUrl(swaggerProperty.getLicenseUrl()).
										description(swaggerProperty.getDescription()).
											build();
	}
}
