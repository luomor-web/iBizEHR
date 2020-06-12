/**
 * JZJSQR 部件模型
 *
 * @export
 * @class JZJSQRModel
 */
export default class JZJSQRModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JZJSQRModel
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
        prop: 'pcmydjzmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmydjzmxname',
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
        name: 'pcmydjzmxid',
        prop: 'pcmydjzmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmydjzmx',
        prop: 'pcmydjzmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}