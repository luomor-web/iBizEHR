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
        prop: 'salruleid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salrulename',
        dataType: 'TEXT',
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
        name: 'salrulename',
        prop: 'salrulename',
        dataType: 'TEXT',
      },
      {
        name: 'salparamname',
        prop: 'salparamname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'salparamid',
        prop: 'salparamid',
        dataType: 'PICKUP',
      },
      {
        name: 'salruleid',
        prop: 'salruleid',
        dataType: 'GUID',
      },
      {
        name: 'salrule',
        prop: 'salruleid',
        dataType: 'FONTKEY',
      },
    ]
  }

}