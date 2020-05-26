/**
 * ZWBZMX 部件模型
 *
 * @export
 * @class ZWBZMXModel
 */
export default class ZWBZMXModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof ZWBZMXModel
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
        prop: 'ormdepestmanid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormdepestmanname',
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
        name: 'ormzwbzid',
        prop: 'ormzwbzid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormzwbzmc',
        prop: 'ormzwbzmc',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'ormdutyname',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'numcompilation',
        prop: 'numcompilation',
        dataType: 'INT',
      },
      {
        name: 'ormdutyid',
        prop: 'ormdutyid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormdepestmanid',
        prop: 'ormdepestmanid',
        dataType: 'GUID',
      },
      {
        name: 'ormdepestman',
        prop: 'ormdepestmanid',
        dataType: 'FONTKEY',
      },
    ]
  }

}