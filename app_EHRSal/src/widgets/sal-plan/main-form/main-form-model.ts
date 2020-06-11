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
        prop: 'salplanid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salplanname',
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
        name: 'salplanname',
        prop: 'salplanname',
        dataType: 'TEXT',
      },
      {
        name: 'nyear',
        prop: 'nyear',
        dataType: 'NSCODELIST',
      },
      {
        name: 'nmonth',
        prop: 'nmonth',
        dataType: 'NSCODELIST',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'salschemename',
        prop: 'salschemename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'state',
        prop: 'state',
        dataType: 'SSCODELIST',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'salplanid',
        prop: 'salplanid',
        dataType: 'GUID',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'salschemeid',
        prop: 'salschemeid',
        dataType: 'PICKUP',
      },
      {
        name: 'salplan',
        prop: 'salplanid',
        dataType: 'FONTKEY',
      },
    ]
  }

}