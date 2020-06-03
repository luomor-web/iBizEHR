/**
 * DGCK 部件模型
 *
 * @export
 * @class DGCKModel
 */
export default class DGCKModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DGCKModel
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
        prop: 'pcmyddgmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmyddgmxname',
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
        name: 'yrank',
        prop: 'yrank',
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
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'INHERIT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'INHERIT',
      },
      {
        name: 'ormorgid',
        prop: 'zzid',
        dataType: 'INHERIT',
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
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'reason',
        prop: 'reason',
        dataType: 'TEXT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'finished',
        prop: 'finished',
        dataType: 'INHERIT',
      },
      {
        name: 'dglx',
        prop: 'dglx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pcmyddgmxid',
        prop: 'pcmyddgmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmyddgmx',
        prop: 'pcmyddgmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}