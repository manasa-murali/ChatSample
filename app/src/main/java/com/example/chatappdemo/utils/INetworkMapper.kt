package com.example.chatappdemo.utils

/**
 * Created by Manasa on 29,June,2021
 */
interface INetworkMapper<Domain, Entity> {

    fun mapFromEntity(entity: Entity) : Domain

}