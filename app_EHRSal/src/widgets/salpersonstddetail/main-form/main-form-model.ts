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
        prop: 'salpersonstddetailid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salpersonstddetailname',
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
        name: 'salpersonstdid',
        prop: 'salpersonstdid',
        dataType: 'PICKUP',
      },
      {
        name: 'salschemeitemname',
        prop: 'salschemeitemname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ywms',
        prop: 'ywms',
        dataType: 'TEXT',
      },
      {
        name: 'xc',
        prop: 'xc',
        dataType: 'FLOAT',
      },
      {
        name: 'salpersonstddetailid',
        prop: 'salpersonstddetailid',
        dataType: 'GUID',
      },
      {
        name: 'salschemeitemid',
        prop: 'salschemeitemid',
        dataType: 'PICKUP',
      },
      {
        name: 'salpersonstddetail',
        prop: 'salpersonstddetailid',
        dataType: 'FONTKEY',
      },
    ]
  }

}