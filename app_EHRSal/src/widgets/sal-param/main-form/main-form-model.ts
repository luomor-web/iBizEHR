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
        prop: 'salparamid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salparamname',
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
        name: 'salparamname',
        prop: 'salparamname',
        dataType: 'TEXT',
      },
      {
        name: 'salsourcename',
        prop: 'salsourcename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'param',
        prop: 'param',
        dataType: 'TEXT',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'salparamid',
        prop: 'salparamid',
        dataType: 'GUID',
      },
      {
        name: 'salsourceid',
        prop: 'salsourceid',
        dataType: 'PICKUP',
      },
      {
        name: 'salparam',
        prop: 'salparamid',
        dataType: 'FONTKEY',
      },
    ]
  }

}