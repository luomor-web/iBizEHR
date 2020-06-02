/**
 * TXQREditForm 部件模型
 *
 * @export
 * @class TXQREditFormModel
 */
export default class TXQREditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof TXQREditFormModel
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
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
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
        dataType: 'GUID',
      },
      {
        name: 'sjtxrq',
        prop: 'sjtxrq',
        dataType: 'DATE',
      },
      {
        name: 'retiplace',
        prop: 'retiplace',
        dataType: 'TEXT',
      },
      {
        name: 'jtlxrid',
        prop: 'jtlxrid',
        dataType: 'TEXT',
      },
      {
        name: 'jtlxr',
        prop: 'jtlxr',
        dataType: 'TEXT',
      },
      {
        name: 'jtlxrdh',
        prop: 'jtlxrdh',
        dataType: 'TEXT',
      },
      {
        name: 'csrq',
        prop: 'csrq',
        dataType: 'DATE',
      },
      {
        name: 'pimperson',
        prop: 'pimpersonid',
        dataType: 'FONTKEY',
      },
    ]
  }

}