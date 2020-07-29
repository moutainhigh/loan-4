package com.aoying.loan.cust;

import java.util.List;

import com.dongfang.api.DongFangApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.aoying.loan.common.config.convert.DateConvert;
import com.aoying.loan.common.config.convert.SqlDateConvert;
import com.aoying.loan.common.config.convert.TimestampConvert;
import com.aoying.loan.common.util.JsonTool;
import com.aoying.loan.cust.interceptor.ApiInterceptor;
import com.aoying.loan.cust.interceptor.MgmtInterceptor;
import com.ds.api.DsApi;
import com.ds.api.DsConfig;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.xinyan.api.XinYanApi;
import com.xinyan.api.XinYanApiMock;
import com.xinyan.api.XinYanConfig;
import com.yuanjin.api.YuanJinApi;

/**
 * @author nick
 */
@SpringBootApplication(scanBasePackages = {"com.aoying.loan"})
@EnableEurekaClient
public class LoanCustApplication extends WebMvcConfigurerAdapter {
	@Value("${sysCfg.isRelease}")
	private Boolean isRelease;

	@Autowired
	private ApiInterceptor apiInterceptor;
	@Autowired
	private MgmtInterceptor mgmtInterceptor;

	/**
	 * 拦截器
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(apiInterceptor).addPathPatterns("/*/api/**");
		registry.addInterceptor(mgmtInterceptor).addPathPatterns("/*/mgmt/**");
		super.addInterceptors(registry);
	}

	/**
	 * 转换request传入日期格式
	 * @param registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new DateConvert());
		registry.addConverter(new SqlDateConvert());
		registry.addConverter(new TimestampConvert());
		super.addFormatters(registry);
	}

	/**
	 * 转换response返回json格式
	 *
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		JsonTool.addConverter(converters);
		super.configureMessageConverters(converters);
	}

	/**
	 * 解决跨域请求，注册CORS过滤器
	 * @return
	 */
	@Bean
	public CorsFilter getCorsFilter() {
		CorsConfiguration cfg = new CorsConfiguration();
		cfg.addAllowedOrigin("*");// 允许跨域访问的域名
		cfg.addAllowedHeader("*");// 请求头

		UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		configurationSource.registerCorsConfiguration("/**", cfg.applyPermitDefaultValues());
		return new CorsFilter(configurationSource);
	}

	@Bean
	public WXPay wxPayApi(@Qualifier("wxPayCfgOfBaiKa") WXPayConfig config) throws Exception {
		return new WXPay(config, config.getNotifyUrl());
	}

	@Bean
	public XinYanApi xinYanApi(XinYanConfig config) {
		if (isRelease) {
			return new XinYanApi(config);
		} else {
			return new XinYanApiMock(config);
		}
	}

	@Bean
	public DsApi dsApi(DsConfig config) {
		return new DsApi(config);
	}

	@Bean
	public YuanJinApi yuanJinApi() {
		if (isRelease) {
			return new YuanJinApi();
		} else {
			return new YuanJinApi();
		}
	}

	@Bean
	public DongFangApi dongFangApi(DsConfig config) {
		return new DongFangApi();
	}


	public static void main(String[] args) {
		SpringApplication.run(LoanCustApplication.class, args);
	}
}