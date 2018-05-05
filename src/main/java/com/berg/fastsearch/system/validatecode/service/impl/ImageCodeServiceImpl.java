package com.berg.fastsearch.system.validatecode.service.impl;

import com.berg.fastsearch.system.validatecode.entity.ImageCode;
import com.berg.fastsearch.system.validatecode.generator.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * <p></p>
 *
 * @author bo.he02@hand-china.com
 * @version v1.0
 * @apiNote Created on 18-5-4
 */
@Service("imageCodeServiceImpl")
public class ImageCodeServiceImpl extends AbstractValidateCodeService<ImageCode> {

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Override
    protected ImageCode generate(ServletWebRequest request) {
        return (ImageCode) imageCodeGenerator.generate(request);
    }

    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
