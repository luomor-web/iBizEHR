/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimvocationalid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zgzsbh',
        prop: 'zgzsbh',
        dataType: 'TEXT',
      },
      {
        name: 'zslx',
        prop: 'zslx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimqualtypename',
        prop: 'pimqualtypename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimqualmajorname',
        prop: 'pimqualmajorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zsmc',
        prop: 'zsmc',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimvocationalcatalogid',
        prop: 'pimvocationalcatalogid',
        dataType: 'PICKUP',
      },
      {
        name: 'zgsydw',
        prop: 'zgsydw',
        dataType: 'TEXT',
      },
      {
        name: 'regisnumber',
        prop: 'regisnumber',
        dataType: 'TEXT',
      },
      {
        name: 'ormsignorgid',
        prop: 'ormsignorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormsignorgname',
        prop: 'ormsignorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'socsecpayunit',
        prop: 'socsecpayunit',
        dataType: 'TEXT',
      },
      {
        name: 'bcardnumber',
        prop: 'bcardnumber',
        dataType: 'TEXT',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jlczz',
        prop: 'jlczz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormorgid2',
        prop: 'ormorgid2',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zghqrq',
        prop: 'zghqrq',
        dataType: 'DATE',
      },
      {
        name: 'cszcsj',
        prop: 'cszcsj',
        dataType: 'DATE',
      },
      {
        name: 'xzcsj',
        prop: 'xzcsj',
        dataType: 'DATE',
      },
      {
        name: 'sxrq',
        prop: 'sxrq',
        dataType: 'DATE',
      },
      {
        name: 'nsqk',
        prop: 'nsqk',
        dataType: 'TEXT',
      },
      {
        name: 'syqk',
        prop: 'syqk',
        dataType: 'TEXT',
      },
      {
        name: 'alteration',
        prop: 'alteration',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimvocationalid',
        prop: 'pimvocationalid',
        dataType: 'GUID',
      },
      {
        name: 'pimqualtypeid',
        prop: 'pimqualtypeid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimqualmajorid',
        prop: 'pimqualmajorid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimvocational',
        prop: 'pimvocationalid',
        dataType: 'FONTKEY',
      },
    ]
  }

}