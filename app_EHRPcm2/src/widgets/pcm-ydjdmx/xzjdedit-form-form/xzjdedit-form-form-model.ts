/**
 * XZJDEditForm 部件模型
 *
 * @export
 * @class XZJDEditFormModel
 */
export default class XZJDEditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof XZJDEditFormModel
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
        prop: 'pcmydjdmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmydjdmxname',
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
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'INHERIT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
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
        name: 'jdksrq',
        prop: 'jdksrq',
        dataType: 'DATE',
      },
      {
        name: 'jdjsrq',
        prop: 'jdjsrq',
        dataType: 'DATE',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormdutyname',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormdutyid',
        prop: 'ormdutyid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'PICKUP',
      },
      {
        name: 'finished',
        prop: 'finished',
        dataType: 'INHERIT',
      },
      {
        name: 'isfinished',
        prop: 'isfinished',
        dataType: 'YESNO',
      },
      {
        name: 'pcmydjdmxid',
        prop: 'pcmydjdmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmydjdmx',
        prop: 'pcmydjdmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}