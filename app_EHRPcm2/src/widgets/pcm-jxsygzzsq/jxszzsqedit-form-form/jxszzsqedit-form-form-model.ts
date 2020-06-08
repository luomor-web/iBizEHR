/**
 * JXSZZSQEditForm 部件模型
 *
 * @export
 * @class JXSZZSQEditFormModel
 */
export default class JXSZZSQEditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JXSZZSQEditFormModel
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
        prop: 'pcmjxsygzzsqid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmjxsygzzsqname',
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
        name: 'pcmjxsygzzsqid',
        prop: 'pcmjxsygzzsqid',
        dataType: 'GUID',
      },
      {
        name: 'pcmjxsygzzsqname',
        prop: 'pcmjxsygzzsqname',
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
        name: 'czrid',
        prop: 'czrid',
        dataType: 'TEXT',
      },
      {
        name: 'pcmjxsygzzsq',
        prop: 'pcmjxsygzzsqid',
        dataType: 'FONTKEY',
      },
    ]
  }

}