/**
 * XZGZCEditForm 部件模型
 *
 * @export
 * @class XZGZCEditFormModel
 */
export default class XZGZCEditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof XZGZCEditFormModel
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'INHERIT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'INHERIT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'INHERIT',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'INHERIT',
      },
      {
        name: 'zzid',
        prop: 'zzid',
        dataType: 'INHERIT',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'INHERIT',
      },
      {
        name: 'bmid',
        prop: 'bmid',
        dataType: 'INHERIT',
      },
      {
        name: 'yzw',
        prop: 'yzw',
        dataType: 'INHERIT',
      },
      {
        name: 'ygw',
        prop: 'ygw',
        dataType: 'INHERIT',
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
        name: 'wbzz',
        prop: 'wbzz',
        dataType: 'TEXT',
      },
      {
        name: 'wwzzid',
        prop: 'wwzzid',
        dataType: 'TEXT',
      },
      {
        name: 'wbbm',
        prop: 'wbbm',
        dataType: 'TEXT',
      },
      {
        name: 'wbzw',
        prop: 'wbzw',
        dataType: 'TEXT',
      },
      {
        name: 'wbgw',
        prop: 'wbgw',
        dataType: 'TEXT',
      },
      {
        name: 'finished',
        prop: 'finished',
        dataType: 'INHERIT',
      },
      {
        name: 'gztype',
        prop: 'gztype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pcmydgzmxid',
        prop: 'pcmydgzmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmydgzmx',
        prop: 'pcmydgzmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}