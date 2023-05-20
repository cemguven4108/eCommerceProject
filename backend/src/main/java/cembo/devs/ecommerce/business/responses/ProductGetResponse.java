package cembo.devs.ecommerce.business.responses;

import cembo.devs.ecommerce.entities.SubCategory;

public record ProductGetResponse(
        int id,
        String name,
        String price,
        String stock,
        String description,
        SubCategory subCategory
) {}
