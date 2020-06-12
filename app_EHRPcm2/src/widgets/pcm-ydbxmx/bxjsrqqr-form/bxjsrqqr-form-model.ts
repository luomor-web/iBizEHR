/**
 * BXJSRQQR 部件模型
 *
 * @export
 * @class BXJSRQQRModel
 */
export default class BXJSRQQRModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof BXJSRQQRModel
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
        prop: 'pcmydbxmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmydbxmxname',
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
        name: 'sxrq',
        prop: 'sxrq',
        dataType: 'INHERIT',
      },
      {
        name: 'jsrq',
        prop: 'jsrq',
        dataType: 'DATE',
      },
      {
        name: 'pcmydbxmxid',
        prop: 'pcmydbxmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmydbxmx',
        prop: 'pcmydbxmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}