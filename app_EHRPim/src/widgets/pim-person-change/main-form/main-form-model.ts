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
        prop: 'pimpersonchangeid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonchangename',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'bglx',
        prop: 'bglx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bgnr',
        prop: 'bgnr',
        dataType: 'TEXT',
      },
      {
        name: 'sqsj',
        prop: 'sqsj',
        dataType: 'DATE',
      },
      {
        name: 'sxsj',
        prop: 'sxsj',
        dataType: 'DATE',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pimpersonchangeid',
        prop: 'pimpersonchangeid',
        dataType: 'GUID',
      },
      {
        name: 'pimpersonchange',
        prop: 'pimpersonchangeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}