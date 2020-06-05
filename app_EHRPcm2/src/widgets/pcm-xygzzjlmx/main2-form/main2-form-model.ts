/**
 * Main2 部件模型
 *
 * @export
 * @class Main2Model
 */
export default class Main2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main2Model
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
        prop: 'pcmxygzzjlmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmxygzzjlmxname',
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
        name: 'zzid',
        prop: 'zzid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'bmid',
        prop: 'bmid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'rzqd',
        prop: 'rzqd',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zzgw',
        prop: 'zzgw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
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
        name: 'pcmxygzzkhjgjlname',
        prop: 'pcmxygzzkhjgjlname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jssj',
        prop: 'jssj',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'qssj',
        prop: 'qssj',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zzsj',
        prop: 'zzsj',
        dataType: 'DATE',
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
        name: 'pcmxygzzjlmxid',
        prop: 'pcmxygzzjlmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmxygzzjlmx',
        prop: 'pcmxygzzjlmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}