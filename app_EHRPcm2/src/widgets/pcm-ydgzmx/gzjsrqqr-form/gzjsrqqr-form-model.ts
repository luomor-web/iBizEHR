/**
 * GZJSRQQR 部件模型
 *
 * @export
 * @class GZJSRQQRModel
 */
export default class GZJSRQQRModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof GZJSRQQRModel
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
        prop: 'pcmydgzmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmydgzmxname',
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
        name: 'pcmydgzmxid',
        prop: 'pcmydgzmxid',
        dataType: 'GUID',
      },
      {
        name: 'ksrq',
        prop: 'ksrq',
        dataType: 'DATE',
      },
      {
        name: 'jsrq',
        prop: 'jsrq',
        dataType: 'DATE',
      },
      {
        name: 'pcmydgzmx',
        prop: 'pcmydgzmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}