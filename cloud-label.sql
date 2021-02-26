use `cloud_label`;

INSERT INTO cloud_label.e_upms_menu (`code`, `icon`, `id`, `name`, `param`, `sort`, `status`, `type`, `value`)
VALUES ('Category', null, '18', '商品分类', null, '10', '1', 'tree', 'Category'),
       ('Store', null, '19', '门店管理', null, '70', '1', 'table', 'Store'),
       ('CommodityManagement', 'fa fa-shopping-cart', '20', '商品管理', null, '90', '1', null, null),
       ('CommodityList', null, '21', '商品列表', null, '20', '1', 'table', 'CommodityList'),
       ('Device', 'fa fa-sitemap', '23', '设备管理', null, '100', '1', null, null),
       ('Template', 'fa fa-newspaper-o', '25', '模板管理', null, '110', '1', 'table', 'Template'),
       ('AccessPoint', null, '26', '基站管理', null, '10', '1', 'table', 'AccessPoint'),
       ('Esl', null, '27', '价签管理', null, '20', '1', 'table', 'Esl');

UPDATE cloud_label.e_upms_menu
SET `parent_menu_id` = '20'
WHERE `id` = '18';
UPDATE cloud_label.e_upms_menu
SET `parent_menu_id` = '20'
WHERE `id` = '21';
UPDATE cloud_label.e_upms_menu
SET `parent_menu_id` = '23'
WHERE `id` = '26';
UPDATE cloud_label.e_upms_menu
SET `parent_menu_id` = '23'
WHERE `id` = '27';