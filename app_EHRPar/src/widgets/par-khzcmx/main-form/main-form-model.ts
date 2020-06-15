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
        prop: 'parkhzcmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parkhzcmxname',
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
        name: 'parassesstemplateid',
        prop: 'parassesstemplateid',
        dataType: 'PICKUP',
      },
      {
        name: 'parassesstemplatename',
        prop: 'parassesstemplatename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'khnr',
        prop: 'khnr',
        dataType: 'SSCODELIST',
      },
      {
        name: 'szqz',
        prop: 'szqz',
        dataType: 'FLOAT',
      },
      {
        name: 'parkhzcmxid',
        prop: 'parkhzcmxid',
        dataType: 'GUID',
      },
      {
        name: 'parkhzcmx',
        prop: 'parkhzcmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}