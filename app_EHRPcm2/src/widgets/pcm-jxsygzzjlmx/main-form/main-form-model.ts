/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        prop: 'pcmjxsygzzjlmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmjxsygzzjlmxname',
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
        dataType: 'PICKUP',
      },
      {
        name: 'pcmjxsygzzsqname',
        prop: 'pcmjxsygzzsqname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pcmjxszzkhjgjlid',
        prop: 'pcmjxszzkhjgjlid',
        dataType: 'PICKUP',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zzgw',
        prop: 'zzgw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'rzqd',
        prop: 'rzqd',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'istemp',
        prop: 'istemp',
        dataType: 'YESNO',
      },
      {
        name: 'finished',
        prop: 'finished',
        dataType: 'YESNO',
      },
      {
        name: 'checkstatus',
        prop: 'checkstatus',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pcmjxszzkhjgjlname',
        prop: 'pcmjxszzkhjgjlname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'qssj',
        prop: 'qssj',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'jssj',
        prop: 'jssj',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'fs',
        prop: 'fs',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pj',
        prop: 'pj',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pcmjxsygzzjlmxid',
        prop: 'pcmjxsygzzjlmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmjxsygzzjlmx',
        prop: 'pcmjxsygzzjlmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}