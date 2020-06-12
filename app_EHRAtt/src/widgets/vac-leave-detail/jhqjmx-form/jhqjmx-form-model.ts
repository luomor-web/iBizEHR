/**
 * JHQJMX 部件模型
 *
 * @export
 * @class JHQJMXModel
 */
export default class JHQJMXModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JHQJMXModel
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
        prop: 'vacleavedetailid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'vacleavedetailname',
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
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'qjzl',
        prop: 'qjzl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'hyzk',
        prop: 'hyzk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'tqlx',
        prop: 'tqlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'njsy',
        prop: 'njsy',
        dataType: 'TEXT',
      },
      {
        name: 'tips',
        prop: 'tips',
        dataType: 'TEXT',
      },
      {
        name: 'jhkssj',
        prop: 'jhkssj',
        dataType: 'DATE',
      },
      {
        name: 'jhkssxw',
        prop: 'jhkssxw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jhjssj',
        prop: 'jhjssj',
        dataType: 'DATE',
      },
      {
        name: 'jhjssxw',
        prop: 'jhjssxw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jhts',
        prop: 'jhts',
        dataType: 'FLOAT',
      },
      {
        name: 'state',
        prop: 'state',
        dataType: 'SSCODELIST',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'TEXT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'vacleavedetailid',
        prop: 'vacleavedetailid',
        dataType: 'GUID',
      },
      {
        name: 'vacleavedetail',
        prop: 'vacleavedetailid',
        dataType: 'FONTKEY',
      },
    ]
  }

}