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
        prop: 'salschemeitemid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salitemname',
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
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'salitemname',
        prop: 'salitemname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sitemadd',
        prop: 'sitemadd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sitemtype',
        prop: 'sitemtype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'FLOAT',
      },
      {
        name: 'salrulename',
        prop: 'salrulename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'gs',
        prop: 'gs',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'salschemeid',
        prop: 'salschemeid',
        dataType: 'PICKUP',
      },
      {
        name: 'salitemid',
        prop: 'salitemid',
        dataType: 'PICKUP',
      },
      {
        name: 'salruleid',
        prop: 'salruleid',
        dataType: 'PICKUP',
      },
      {
        name: 'salschemeitemid',
        prop: 'salschemeitemid',
        dataType: 'GUID',
      },
      {
        name: 'salschemeitem',
        prop: 'salschemeitemid',
        dataType: 'FONTKEY',
      },
    ]
  }

}