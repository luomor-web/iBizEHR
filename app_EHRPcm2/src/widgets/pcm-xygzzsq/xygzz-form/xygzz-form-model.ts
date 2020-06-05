/**
 * XYGZZ 部件模型
 *
 * @export
 * @class XYGZZModel
 */
export default class XYGZZModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof XYGZZModel
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
        prop: 'pcmxygzzsqid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmxygzzsqname',
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
        name: 'pcmxygzzsqid',
        prop: 'pcmxygzzsqid',
        dataType: 'GUID',
      },
      {
        name: 'pcmxygzzsqname',
        prop: 'pcmxygzzsqname',
        dataType: 'TEXT',
      },
      {
        name: 'czr',
        prop: 'czr',
        dataType: 'TEXT',
      },
      {
        name: 'czrq',
        prop: 'czrq',
        dataType: 'DATE',
      },
      {
        name: 'sxrq',
        prop: 'sxrq',
        dataType: 'DATE',
      },
      {
        name: 'zzlx',
        prop: 'zzlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pcmxygzzsq',
        prop: 'pcmxygzzsqid',
        dataType: 'FONTKEY',
      },
    ]
  }

}