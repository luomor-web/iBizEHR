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
        prop: 'ormqybzwhid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormqybzwhname',
        dataType: 'SSCODELIST',
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
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormqybzwhname',
        prop: 'ormqybzwhname',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ms',
        prop: 'ms',
        dataType: 'TEXT',
      },
      {
        name: 'ormqybzwhid',
        prop: 'ormqybzwhid',
        dataType: 'GUID',
      },
      {
        name: 'ormqybzwh',
        prop: 'ormqybzwhid',
        dataType: 'FONTKEY',
      },
    ]
  }

}