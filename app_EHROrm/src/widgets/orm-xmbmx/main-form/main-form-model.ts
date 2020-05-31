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
        prop: 'ormxmbmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormxmbmxname',
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
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'xmrylx',
        prop: 'xmrylx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zsmc',
        prop: 'zsmc',
        dataType: 'TEXT',
      },
      {
        name: 'zsbh',
        prop: 'zsbh',
        dataType: 'TEXT',
      },
      {
        name: 'ormxmbmxid',
        prop: 'ormxmbmxid',
        dataType: 'GUID',
      },
      {
        name: 'ormxmbmx',
        prop: 'ormxmbmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}