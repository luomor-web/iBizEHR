/**
 * ReasonEdit 部件模型
 *
 * @export
 * @class ReasonEditModel
 */
export default class ReasonEditModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof ReasonEditModel
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
        name: 'reason',
        prop: 'reason',
        dataType: 'LONGTEXT_1000',
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